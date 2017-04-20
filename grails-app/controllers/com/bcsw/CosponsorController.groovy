package com.bcsw

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CosponsorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cosponsor.list(params), model:[cosponsorCount: Cosponsor.count()]
    }

    def show(Cosponsor cosponsor) {
        respond cosponsor
    }

    def create() {
        respond new Cosponsor(params)
    }

    @Transactional
    def save(Cosponsor cosponsor) {
        if (cosponsor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cosponsor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cosponsor.errors, view:'create'
            return
        }

        cosponsor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cosponsor.label', default: 'Cosponsor'), cosponsor.id])
                redirect cosponsor
            }
            '*' { respond cosponsor, [status: CREATED] }
        }
    }

    def edit(Cosponsor cosponsor) {
        respond cosponsor
    }

    @Transactional
    def update(Cosponsor cosponsor) {
        if (cosponsor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cosponsor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cosponsor.errors, view:'edit'
            return
        }

        cosponsor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cosponsor.label', default: 'Cosponsor'), cosponsor.id])
                redirect cosponsor
            }
            '*'{ respond cosponsor, [status: OK] }
        }
    }

    @Transactional
    def delete(Cosponsor cosponsor) {

        if (cosponsor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cosponsor.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cosponsor.label', default: 'Cosponsor'), cosponsor.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cosponsor.label', default: 'Cosponsor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
