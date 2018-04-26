$.getJSON("runner.json", function (data) {
    // Write the data into our global variable.
    products = data;
    // json  to variable
    // Call a function to create HTML for all the products.
    generateAllProductsHTML(products);
    // Manually trigger a hashchange to start the app.
    $(window).trigger('hashchange');
});

function generateAllProductsHTML(data) {
    //Generate  data
    var list = $(".multi-level");
    var theTemplateScript = $('#skills-template').html();
    var theTemplate = Handlebars.compile(theTemplateScript);
    list.append(theTemplate(data));
}

//Get id of active element
var chbx = $('.sub-item :checkbox').on('change', function() {
    console.log('Value: ' + $(this).val() + '\n' + 'ID: ' + $(this).attr('id') + '\n' + 'Index: ' + chbx.index(this));
});

//Change name function
$('#changeName').click(function () {
    var chbx = $('.sub-item :checkbox').on('change');
    arr = chbx.attr('id').split('-');
    $.ajax({
        type: "GET",
        cache: false,
        url: 'controller',
        data: {
            'command': 'change_val',
            'name': $("#change").val(),
            'row': arr[1],
            'col': arr[0]
        },
        success: function (response) {
            //JS part to change name
            // var chbx = $('.sub-item :checkbox').on('change');
            // document.getElementById(chbx.attr('id')).innerHTML='hh';
            $('#content').html(response);
            $.getJSON("runner.json", function (data) {
                generateAllSkillsHTML(data);
            });
        },
        error: function()
        {
            $('#content').html("Nothing");
        }
    });
});


//Add element function
$('#addElement').click(function () {
    var chbx = $('.sub-item :checkbox').on('change');
    arr = chbx.attr('id').split('-');
    $.ajax({
        type: "GET",
        cache: false,
        url: 'controller',
        data: {
            'command': 'add_val',
            'name': $("#add").val(),
            'row': arr[1],
            'col': arr[0]
        },
        success: function (response) {
            /* JS part to add element
            // /* Adds Element BEFORE NeighborElement */
            // Element.prototype.appendBefore = function (element) {
            //     element.parentNode.insertBefore(this, element);
            // }, false;
            // var chbx = $('.sub-item :checkbox').on('change');
            // /* Adds Element AFTER NeighborElement */
            // Element.prototype.appendAfter = function (element) {
            //     element.parentNode.insertBefore(this, element.nextSibling);
            // }, false;
            // /* Typical Creation and Setup A New Orphaned Element Object */
            // var NewElement = document.createElement('div');
            // NewElement.innerHTML = $("#add").val();
            // NewElement.id = 'new';
            // /*  Add NewElement BEFORE -OR- AFTER Using the Aforementioned Prototypes */
            // NewElement.appendAfter(document.getElementById(chbx.attr('id')));

            $('#content').html(response);
            $.getJSON("runner.json", function (data) {
                generateAllSkillsHTML(data);
            });
        },
        error: function()
        {
            $('#content').html("Nothing");
        }
    });
});

// delete element
$('#delElement').click(function () {
    var chbx = $('.sub-item :checkbox').on('change');
    arr = chbx.attr('id').split('-');
    $.ajax({
        type: "GET",
        cache: false,
        url: 'controller',
        data: {
            'command': 'delete_val',
            'row': arr[1],
            'col': arr[0]
        },
        success: function (response) {
            //JS part delete element
            // var chbx = $('.sub-item :checkbox').on('change');
            // var elem = document.getElementById(chbx.attr('id'));
            $('#content').html(response);
            $.getJSON("runner.json", function (data) {
                generateAllSkillsHTML(data);
            });
            // elem.remove();
        },
        error: function()
        {
            $('#content').html("Nothing");
        }
    });
});

// get id and parse on row and col
//arr = chbx.attr('id').split('-');
//var row= arr[0];
//var col = arr[1];

//Search function
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
        if (jQuery('#spterm').val()!=term)
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



