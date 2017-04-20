<%@ page import="com.bcsw.Rep" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'bill.label', default: 'Bill')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-bill" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-bill" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.bill}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.bill}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <form action="/bill/save" method="post">
                <fieldset class="form">
                    <div class="row">
                        <div class="input-field col s12">
                            <input type="text" name="billName" id="billName">
                            <label for="billName">Bill Name</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <select name="billPre" id="billPre">
                                <option value="" disabled selected>Choose Bill Prefix</option>
                                <option value="H.R.">H.R.</option>
                                <option value="S.R.">S.R.</option>
                            </select>
                            <label > Bill Prefix</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input type="text" name="number" id="number">
                            <label for="number">Bill Number</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input type="number" name="dateIntro" id="dateIntro">

                            <label for="dateIntro">Date Introduced</label>
                        </div>
                    </div>

                    <div class="input-field col s12">
                        <g:select from="${com.bcsw.Rep.list()}" name="sponsor" optionKey="id" multiple="true" />
                        <label>Select Sponsor(s)</label>
                    </div>

                    <div class="input-field col s12">
                        <g:select from="${com.bcsw.Rep.list()}" name="cosponsor" optionKey="id" multiple="true" />
                        <label>Select Cosponsor(s)</label>
                    </div>


                    <div class="input-field col s12">
                        <g:select from="${com.bcsw.Committee.list()}" name="committee"  optionKey="id" multiple="true" />
                        <label>Select Committee</label>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <textarea class="materialize-textarea" name="summary" id="summary"></textarea>
                            <label for="summary">Summary</label>
                        </div>
                    </div>

                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </form>
        </div>
    </body>
</html>
