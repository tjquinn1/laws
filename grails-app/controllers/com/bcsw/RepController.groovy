package com.bcsw

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RepController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Rep.list(params), model:[repCount: Rep.count()]
    }

    def show(Rep rep) {
        respond rep
    }

    def create() {
        respond new Rep(params)
    }

    @Transactional
    def save(Rep rep) {
        if (rep == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rep.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rep.errors, view:'create'
            return
        }

        rep.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rep.label', default: 'Rep'), rep.id])
                redirect rep
            }
            '*' { respond rep, [status: CREATED] }
        }
    }

    def edit(Rep rep) {
        respond rep
    }

    @Transactional
    def update(Rep rep) {
        if (rep == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rep.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rep.errors, view:'edit'
            return
        }

        rep.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rep.label', default: 'Rep'), rep.id])
                redirect rep
            }
            '*'{ respond rep, [status: OK] }
        }
    }

    @Transactional
    def delete(Rep rep) {

        if (rep == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        rep.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rep.label', default: 'Rep'), rep.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rep.label', default: 'Rep'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
