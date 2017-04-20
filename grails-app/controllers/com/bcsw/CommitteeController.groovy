package com.bcsw

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CommitteeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Committee.list(params), model:[committeeCount: Committee.count()]
    }

    def show(Committee committee) {
        respond committee
    }

    def create() {
        respond new Committee(params)
    }

    @Transactional
    def save(Committee committee) {
        if (committee == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (committee.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond committee.errors, view:'create'
            return
        }

        committee.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'committee.label', default: 'Committee'), committee.id])
                redirect committee
            }
            '*' { respond committee, [status: CREATED] }
        }
    }

    def edit(Committee committee) {
        respond committee
    }

    @Transactional
    def update(Committee committee) {
        if (committee == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (committee.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond committee.errors, view:'edit'
            return
        }

        committee.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'committee.label', default: 'Committee'), committee.id])
                redirect committee
            }
            '*'{ respond committee, [status: OK] }
        }
    }

    @Transactional
    def delete(Committee committee) {

        if (committee == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        committee.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'committee.label', default: 'Committee'), committee.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'committee.label', default: 'Committee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
