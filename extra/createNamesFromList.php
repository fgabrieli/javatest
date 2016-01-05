<?php

$names = file_get_contents('names');

preg_match_all('/(\d+)\t+([a-zA-Z]+)/', $names, $m);

$lastNames = array('Smith', 'Jones', 'Anderson', 'Noclueny', 'Bullock', 'Spacey', 'Skywalker', 'KenObi');

$csv = '';
foreach ($m[2] as $name) {
  $email = strtolower($name) . '@web.com';
  $lastName = $lastNames[rand(0, sizeof($lastNames) - 1)];
  $csv .= $name . ';' . $lastName . ';' . $email . "\n";
}

file_put_contents('address-book.csv', $csv);