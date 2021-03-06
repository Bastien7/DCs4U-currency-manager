package com.dcs4u.controller

import com.dcs4u.controller.ControllerUrl.TRANSACTION_API
import com.dcs4u.json.request.TransactionRequest
import com.dcs4u.service.BigChainDbService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping(TRANSACTION_API)
class TransactionController(val bigChainDbService: BigChainDbService) {

    @GetMapping("/{id}")
    fun getTransaction(@PathVariable("id") id: String) = bigChainDbService.getTransaction(id)

    @GetMapping("/currency/{currencyId}")
    fun getTransactionByCurrency(@PathVariable("currencyId") currencyId: String) = bigChainDbService.getTransactionsByCurrency(currencyId)

    @PostMapping
    fun instantiateTransaction(@RequestBody request: TransactionRequest) = bigChainDbService.createTransaction(request)
}