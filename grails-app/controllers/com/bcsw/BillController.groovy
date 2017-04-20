package com.bcsw

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BillController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bill.list(params), model:[billCount: Bill.count()]
    }

    def show(Bill bill) {
        respond bill
    }

    def create() {
        respond new Bill(params)
    }

    @Transactional
    def save(Bill bill) {
        if (bill == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (bill.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond bill.errors, view:'create'
            return
        }

        bill.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bill.label', default: 'Bill'), bill.id])
                redirect bill
            }
            '*' { respond bill, [status: CREATED] }
        }
    }

    def edit(Bill bill) {
        respond bill
    }

    @Transactional
    def update(Bill bill) {
        if (bill == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (bill.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond bill.errors, view:'edit'
            return
        }

        bill.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bill.label', default: 'Bill'), bill.id])
                redirect bill
            }
            '*'{ respond bill, [status: OK] }
        }
    }

    @Transactional
    def delete(Bill bill) {

        if (bill == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        bill.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bill.label', default: 'Bill'), bill.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bill.label', default: 'Bill'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
