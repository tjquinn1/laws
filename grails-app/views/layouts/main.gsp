<!doctype html>
<html lang="en" class="no-js">
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>


    <asset:stylesheet src="materialize.min.css"/>

    <g:layoutHead/>
</head>
<body>
    <nav>
        <div class="nav-wrapper white">
            <a href="${createLink(uri: '/')}" class="brand-logo black-text">Bullet Point Bills</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a class="black-text" href="sass.html">Sass</a></li>
                <li><a class="black-text" href="badges.html">Components</a></li>
                <li><a class="black-text" href="collapsible.html">JavaScript</a></li>
            </ul>
        </div>
    </nav>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>
<!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

    <asset:javascript src="materialize.min.js"/>
    <g:javascript>
        $(document).ready(function() {
            $('select').material_select();
        });

        $('.datepicker').pickadate({
            selectMonths: false, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });

    </g:javascript>

</body>
</html>
