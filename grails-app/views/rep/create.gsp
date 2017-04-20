<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'rep.label', default: 'Rep')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-rep" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-rep" class="content scaffold-create" role="main">
            <div class="row">
                <h1 class="center-align">Create New Representive</h1>
            </div>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.rep}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.rep}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <form action="/rep/save" method="post">
                <fieldset class="form">
                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <input type="text" name="name" id="name">
                            <label for="name">Name</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <select name="party" id="party">
                                <option value="" disabled selected>Party</option>
                                <option value="Democrat">Democrat</option>
                                <option value="Republican">Republican</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <select name="congress" id="congress">
                                <option value="" disabled selected>Chamber</option>
                                <option value="House">House</option>
                                <option value="Senate">Senate</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align"">
                            <i class="material-icons prefix">phone</i>
                                <input type="tel" name="phone" id="phone" class="validate">
                                <label for="phone">Phone</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align"">
                            <input type="number" name="district" id="district">
                            <label for="district">District</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align"">
                            <select name="state" id="state">
                                <option value="" disabled selected>State</option>
                                <option value="Alabama">Alabama</option>
                                <option value="Alaska">Alaska</option>
                                <option value="Arizona">Arizona</option>
                                <option value="Arkansas">Arkansas</option>
                                <option value="California">California</option>
                                <option value="Colorado">Colorado</option>
                                <option value="Connecticut">Connecticut</option>
                                <option value="Delaware">Delaware</option>
                                <option value="District Of Columbia">District Of Columbia</option>
                                <option value="Florida">Florida</option>
                                <option value="Georgia">Georgia</option>
                                <option value="Hawaii">Hawaii</option>
                                <option value="Idaho">Idaho</option>
                                <option value="Illinois">Illinois</option>
                                <option value="Indiana">Indiana</option>
                                <option value="Iowa">Iowa</option>
                                <option value="Kansas">Kansas</option>
                                <option value="Kentucky">Kentucky</option>
                                <option value="Louisiana">Louisiana</option>
                                <option value="Maine">Maine</option>
                                <option value="Maryland">Maryland</option>
                                <option value="Massachusetts">Massachusetts</option>
                                <option value="Michigan">Michigan</option>
                                <option value="Minnesota">Minnesota</option>
                                <option value="Mississippi">Mississippi</option>
                                <option value="Missouri">Missouri</option>
                                <option value="Montana">Montana</option>
                                <option value="Nebraska">Nebraska</option>
                                <option value="Nevada">Nevada</option>
                                <option value="New Hampshire">New Hampshire</option>
                                <option value="New Jersey">New Jersey</option>
                                <option value="New Mexico">New Mexico</option>
                                <option value="New York">New York</option>
                                <option value="North Carolina">North Carolina</option>
                                <option value="North Dakota">North Dakota</option>
                                <option value="Ohio">Ohio</option>
                                <option value="Oklahoma">Oklahoma</option>
                                <option value="Oregon">Oregon</option>
                                <option value="Pennsylvania">Pennsylvania</option>
                                <option value="Rhode Island">Rhode Island</option>
                                <option value="South Carolina">South Carolina</option>
                                <option value="South Dakota">South Dakota</option>
                                <option value="Tennessee">Tennessee</option>
                                <option value="Texas">Texas</option>
                                <option value="Utah">Utah</option>
                                <option value="Vermont">Vermont</option>
                                <option value="Virginia">Virginia</option>
                                <option value="Washington">Washington</option>
                                <option value="West Virginia">West Virginia</option>
                                <option value="Wisconsin">Wisconsin</option>
                                <option value="Wyoming">Wyoming</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align"">
                            <input id="repEmail" name="repEmail" type="email" class="validate">
                            <label for="repEmail">Email</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align"">
                            <input id="street" name="street" type="text" class="validate">
                            <label for="street">Address</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <input name="congStart" id="congStart" type="number">
                            <label for="congStart">Year Start Congress</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <input name="congEnd" id="congEnd" type="number">
                            <label for="congEnd">Year End Congress</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <input name="congNumStart" id="congNumStart" type="number">
                            <label for="congNumStart">Number of First Congress</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3 off center-align">
                            <input name="congNumEnd" id="congNumEnd" type="number">
                            <label for="congNumEnd">Number of Last Congress</label>
                        </div>
                    </div>

                </fieldset>
                <fieldset class="buttons">
                    <div class="row">
                        <div class="col s6 offset-l3 off center-align">
                            <input type="submit" id="create" name="create" value="Create" class="waves-effect waves-teal btn-flat  btn-large">
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
    </body>
</html>
