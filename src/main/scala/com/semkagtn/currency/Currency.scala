package com.semkagtn.currency

object Currency
  extends Enumeration {
  
  type Currency = Value
  
  final val Rur, Eur, Usd = Value
}
