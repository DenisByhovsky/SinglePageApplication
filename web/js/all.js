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
    //Gen data
    var list = $(".multi-level");

    var theTemplateScript = $('#skills-template').html();
    var theTemplate = Handlebars.compile(theTemplateScript);
    list.append(theTemplate(data));}


//active get id el
var chbx = $('.nav :checkbox').on('change', function() {
    console.log('Value: ' + $(this).val() + '\n' + 'ID: ' + $(this).attr('id') + '\n' + 'Index: ' + chbx.index(this));
});

arr = chbx.attr('id').split('-');




//PUT delete elem

$('#changeName').click(function () {

    $.ajax({
        type: "POST",
        cache: false,
        url: 'command',
        data: {
            'name': $("#change").val(),
            'row': arr[0],
            'col': arr[1]
        },
        success: function (response) {
            $('.item').html(response);
        },
        error: function()
        {
            $('.item').html("Nothing");
        }
    });
});


//GET add elem

$('#addElement').click(function () {

    $.ajax({
        type: "GET",
        cache: false,
        url: 'command',
        data: {
            'name': $("#add").val(),
            'row': arr[0],
            'col': arr[1]
        },
        success: function (response) {
            $('.item').html(response);
        },
        error: function()
        {
            $('.item').html("Nothing");
        }
    });
});

//POST del elem

$('#delElement').click(function () {
    $.ajax({
        type: "POST",
        cache: false,
        url: 'command',
        data: {
            'row': arr[0],
            'col': arr[1]
        },
        success: function (response) {
            $('.item').html(response);
        },
        error: function()
        {
            $('.item').html("Nothing");
        }
    });
});



// get id and parse on row and col
//arr = chbx.attr('id').split('-');

//var row= arr[0];
//var col = arr[1];




jQuery(document).ready(function(){
    var minlen = 3;
    var paddingtop = 30;
    var scrollspeed = 200;
    var keyint = 1000;
    var term = '';
    var n = 0;
    var time_keyup = 0;
    var time_search = 0;

    jQuery('body').delegate('#spgo', 'click', function(){
        jQuery('body,html').animate({scrollTop: jQuery('span.highlight:first').offset().top-paddingtop}, scrollspeed);
    });

    function dosearch() {
        term = jQuery('#spterm').val();
        jQuery('span.highlight').each(function(){
            jQuery(this).after(jQuery(this).html()).remove();
        });
        var t = '';
        jQuery('div.nav').each(function(){
            jQuery(this).html(jQuery(this).html().replace(new RegExp(term, 'ig'), '<span class="highlight">$&</span>'));
            n = jQuery('span.highlight').length;
            console.log('n = '+n);
            if (n==0)
                jQuery('#spresult').html('Nothing found');
            else
                jQuery('#spresult').html('Found: '+n+'. <span class="splink" id="spgo">Go next</span>');
            if (n>1)
            {
                var i = 0;
                jQuery('span.highlight').each(function(i){
                    jQuery(this).attr('n', i++);
                });
                jQuery('span.highlight').not(':last').attr({title: 'Click to next element'}).click(function(){
                    jQuery('body,html').animate({scrollTop: jQuery('span.highlight:gt('+jQuery(this).attr('n')+'):first').offset().top-paddingtop}, scrollspeed);
                });
                jQuery('span.highlight:last').attr({title: 'Click to search form'}).click(function(){
                    jQuery('body,html').animate({scrollTop: jQuery('#spterm').offset().top-paddingtop}, scrollspeed);
                });
            }
        });
    }

    jQuery('#spterm').keyup(function(){
        var d1 = new Date();
        time_keyup = d1.getTime();
        if (jQuery('#spterm').val()!=term) // проверяем, изменилась ли строка
            if (jQuery('#spterm').val().length>=minlen) {
                setTimeout(function(){
                    var d2 = new Date();
                    time_search = d2.getTime();
                        dosearch();
                }, keyint);
            }
            else
                jQuery('#spresult').html('&nbsp');
    });

    if (window.location.hash!="")
    {
        var t = window.location.hash.substr(1, 50);
        jQuery('#spterm').val(t).keyup();
        jQuery('#spgo').click();
    }
});



