<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html;charset=Cp1251"/>
    <%--<meta charset="utf-8">--%>

    <title>Skill Matrix</title>

    <%--<link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet">--%>
    <link href="css/styles.css" rel="stylesheet">

</head>

<body>


<div class="main-content">

    <div class="nav">

        <ul class="head-menu">
            <li class="sub-point"><input type="checkbox" id="menu"/>
                <img  src="images/menu.png" class="arrow">
                <label for="menu" id="nav-icon"> Hard Skills</label></li>
            <li class="sub-point"> <input type="checkbox" id="menu1"/>
                <img  src="images/menu.png" class="arrow">
                <label for="menu1" id="nav-icon"> Soft  Skills</label></li>
            <li class="sub-point-1">
                <input id="spterm" type="text" name="spterm" placeholder="Search?"><br />
                <div id="spresult"> </div>
            </li>
        </ul>
        <%--{{#each this}}--%>
        <div class="multi-level">
            <script id="skills-template" type="x-handlebars-template">
                {{#each this}}
                <div class="item">
                    <input type="checkbox" id="{{columnNumber}}-{{rowNumber}}"/>

                    <img  src="images/click.png" class="arrow"><label for="{{rowNumber}}">{{name}}</label>
                    <label  id="{{columnNumber}}-{{rowNumber}}"  for="{{rowNumber}}">{{childList.length}}</label>

                    <ul>
                        {{#each childList}}
                        <li>
                            <div class="sub-item">
                                <input type="checkbox" id="{{columnNumber}}-{{rowNumber}}"/>

                                <img src="images/click.png" class="arrow"><label for="{{rowNumber}}">{{name}}</label>
                                <label id="{{columnNumber}}-{{rowNumber}}"  for="{{rowNumber}}">{{childList.length}}</label>
                                <ul>
                                    {{#each childList}}
                                    <li>
                                        <div class="sub-item-1">
                                            <input type="checkbox" id="{{columnNumber}}-{{rowNumber}}"/>

                                            <img  src="images/click.png" class="arrow"><label
                                                for="{{rowNumber}}">{{name}}</label>
                                                <label for="{{rowNumber}}">{{childList.length}}</label>
                                            <ul>
                                                {{#each childList}}
                                                <li>
                                                    <div class="sub-item-2">
                                                        <input type="checkbox" id="{{rowNumber}}"/>
                                                        <label for="{{rowNumber}}">- {{name}}</label>
                                                        <label for="{{rowNumber}}">{{childList.length}}</label>
                                                    </div>
                                                </li>
                                                {{/each}}
                                            </ul>
                                            {{else}}
                                            <label for="{{rowNumber}}">- {{name}}</label>
                                            <label for="{{rowNumber}}">{{childList.length}}</label>

                                        </div>
                                    </li>
                                    {{/each}}
                                </ul>


                            </div>
                        </li>
                        {{/each}}
                    </ul>

                </div>
                {{/each}}
            </script>
        </div>


    </div>


</div>

<div class="footer-menu">
<ul class="foot-item-add">
<li><input  type="text"  id="add"><br></li>
    <li> <a id="addElement" href="#">Add element</a></li>
</ul>

    <ul class="foot-item-del">
    <li><input type="text" id="delete"></li>
        <li> <a id="delElement" href="#">Delete</a></li>
    </ul>

    <ul class="foot-item-chan">
    <li><input  type="text"  id="change"><br></li>
        <li><a id="changeName" href="#">Change name</a></li>
    </ul>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/handlebars-v4.0.11.js"></script>
<script src="js/all.js"></script>


</body>
</html>