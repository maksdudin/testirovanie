package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
public class AccountRepisitory {


 Map<String,Integer> db = new HashMap<>();

 public int getSumByAccount(String account){
 return db.get(account);
 }

}
