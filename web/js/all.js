$.getJSON("runner.json", function (data) {

    // Write the data into our global variable.
    products = data;
// json  в переменную
    // Call a function to create HTML for all the products.
    generateAllProductsHTML(products);

    // Manually trigger a hashchange to start the app.
    $(window).trigger('hashchange');
});


function generateAllProductsHTML(data) {

    //Ггенерируем данные с handlebars

    // var list = $('.all-skills .skills-list');
    var list = $(".multi-level");

    var theTemplateScript = $('#skills-template').html();
    var theTemplate = Handlebars.compile(theTemplateScript);
    list.append(theTemplate(data));}

//function removeDummy() {
  //  var elem = document.getElementById('#C4');
    //elem.parentNode.removeChild(elem);
    //return false;
//}

//active get id el
var chbx = $('.nav :checkbox').on('change', function() {
    console.log('Value: ' + $(this).val() + '\n' + 'ID: ' + $(this).attr('id') + '\n' + 'Index: ' + chbx.index(this));
});

arr = chbx.attr('id').split('-');


$(function(){
    function getData() {

            var dataToBeSent = {


// get id and parse on row and col


                row : arr[0],
                col : arr[1]


            }; // you can change parameter name

            $.ajax({
                url: 'command', // Your Servlet mapping or JSP(not suggested)
                data: dataToBeSent,
                type: 'GET',
                dataType: 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
                success: function (response) {
                    $('.multi-level').html(response);

                    // create an empty div in your page with some id
                },

                error: function (request, textStatus, errorThrown) {
                    alert(errorThrown);
                }
            });
        }

});



// get id and parse on row and col
//arr = chbx.attr('id').split('-');

//var row= arr[0];
//var col = arr[1];




jQuery(document).ready(function(){
    var minlen = 3; // минимальная длина слова
    var paddingtop = 30; // отступ сверху при прокрутке
    var scrollspeed = 200; // время прокрутки
    var keyint = 1000; // интервал между нажатиями клавиш
    var term = '';
    var n = 0;
    var time_keyup = 0;
    var time_search = 0;

    jQuery('body').delegate('#spgo', 'click', function(){
        jQuery('body,html').animate({scrollTop: jQuery('span.highlight:first').offset().top-paddingtop}, scrollspeed); // переход к первому фрагменту
    });

    function dosearch() {
        term = jQuery('#spterm').val();
        jQuery('span.highlight').each(function(){ //удаляем старую подсветку
            jQuery(this).after(jQuery(this).html()).remove();
        });
        var t = '';
        jQuery('div.nav').each(function(){ // в селекторе задаем область поиска
            jQuery(this).html(jQuery(this).html().replace(new RegExp(term, 'ig'), '<span class="highlight">$&</span>')); // выделяем найденные фрагменты
            n = jQuery('span.highlight').length; // количество найденных фрагментов
            console.log('n = '+n);
            if (n==0)
                jQuery('#spresult').html('Nothing found');
            else
                jQuery('#spresult').html('Found: '+n+'. <span class="splink" id="spgo">Go next</span>');
            if (n>1) // если больше одного фрагмента, то добавляем переход между ними
            {
                var i = 0;
                jQuery('span.highlight').each(function(i){
                    jQuery(this).attr('n', i++); // нумеруем фрагменты, более простого способа искать следующий элемент не нашел
                });
                jQuery('span.highlight').not(':last').attr({title: 'Click to next element'}).click(function(){ // всем фрагментам, кроме последнего, добавляем подсказку
                    jQuery('body,html').animate({scrollTop: jQuery('span.highlight:gt('+jQuery(this).attr('n')+'):first').offset().top-paddingtop}, scrollspeed); // переход к следующему фрагменту
                });
                jQuery('span.highlight:last').attr({title: 'Click to search form'}).click(function(){
                    jQuery('body,html').animate({scrollTop: jQuery('#spterm').offset().top-paddingtop}, scrollspeed); // переход к форме поиска
                });
            }
        });
    }

    jQuery('#spterm').keyup(function(){
        var d1 = new Date();
        time_keyup = d1.getTime();
        if (jQuery('#spterm').val()!=term) // проверяем, изменилась ли строка
            if (jQuery('#spterm').val().length>=minlen) { // проверяем длину строки
                setTimeout(function(){ // ждем следующего нажатия
                    var d2 = new Date();
                    time_search = d2.getTime();
                    if (time_search-time_keyup>=keyint) // проверяем интервал между нажатиями
                        dosearch(); // если все в порядке, приступаем к поиску
                }, keyint);
            }
            else
                jQuery('#spresult').html('&nbsp'); // если строка короткая, убираем текст из DIVа с результатом
    });

    if (window.location.hash!="") // бонус
    {
        var t = window.location.hash.substr(1, 50); // вырезаем текст
        jQuery('#spterm').val(t).keyup(); // вставляем его в форму поиска
        jQuery('#spgo').click(); // переходим к первому фрагменту
    }
});