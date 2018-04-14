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