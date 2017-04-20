package com.bcsw

class BootStrap {

    def init = { servletContext ->
        new Rep(name: "John Daily", party: "Republican", congress: "House", district: 1, state: "Arizona", repEmail: "jd@test1.com", street: "122 E Street way", phone: "4802167844", congStart: 1990, congEnd: 1999, congNumStart: 110, congNumEnd: 112).save()
        new Rep(name: "Danny Markov", party: "Democrat", congress: "Senate", district: 4, state: "California", repEmail: "dmarkov@test.com", street: "4787 N Salamander", phone: "4802167844", congStart: 1990, congEnd: 1999, congNumStart: 110, congNumEnd: 112).save()
        new Rep(name: "Jay Mascus", party: "Democrat", congress: "Senate", district: 4, state: "California", repEmail: "dmarkov@test.com", street: "4787 N Salamander", phone: "4802167844", congStart: 1990, congEnd: 1999, congNumStart: 110, congNumEnd: 112).save()
    }
    def destroy = {
    }
}
