package com.semkagtn.currency

import com.semkagtn.currency.Currency.Currency

class CurrencyConverterImpl
  extends CurrencyConverter {
  
  override def convert(value: BigDecimal, from: Currency, to: Currency): BigDecimal =
    value + 1
}
