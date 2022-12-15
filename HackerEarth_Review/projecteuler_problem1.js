
//Writing a function that  takes in a value check i it a one return
//if greater thta one check if the remainder for each number up to that number is divisible by 3 or 5 if so
// create a variable and sum the value recursively

//let multipleSum = 0;
function solution(number){
    let   multipleSum = 0;
    if(number < 0)
        return 0;
   else if(number == 1)
   return number;

   else {
    for(i = 0; i < number; i++){
      
        if(i%3 == 0 || i%5 == 0){
          multipleSum =multipleSum + i;
            // console.log(multipleSum);
        }
    }
    
   }
   return multipleSum;
}
function solution(number){
    return number < 1 ? 0 : [...new Array(number).keys()].filter(n => n % 3 == 0 || n % 5 == 0).reduce((a, b) => a + b);
  }
  solution= n=> n<=0?0:Array.from({length: n}, (_,i) => (i%3==0||i%5==0)?i:0).reduce((x,y)=>x+y)

  solution = n => {
    let s = 0;
    for (let i = 0; i < n; i++) s += i % 3 ? i % 5 ? 0 : i : i;
    return s;
  }

  function solution(number){
    return number < 3 ? 0
     : [...Array(number).keys()]
      .map(int => (int % 3 === 0 || int % 5 === 0) ? int : 0 )
      .reduce((a, b) => a + b )
  
  }

  function solution(number){
    return number < 0 
      ? 0
      : [...Array(number).keys()]
          .filter(n => n % 3 === 0 || n % 5 === 0 )
          .reduce((n, i) => n + i, 0);
    }
      