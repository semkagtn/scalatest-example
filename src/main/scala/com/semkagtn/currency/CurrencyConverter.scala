package com.semkagtn.currency

import com.semkagtn.currency.Currency.Currency

trait CurrencyConverter {

  /**
   * Converts one currency to another.
   */
  def convert(value: BigDecimal,
              from: Currency,
              to: Currency): BigDecimal
}
