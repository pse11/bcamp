let fs = require('fs');
let input =fs.readFileSync('./example.txt').toString().trim();

let year = parseInt(input);

if(year%4==0&&year%100!=0||year%400==0){
  console.log("1");
}else {
  console.log("0");
}