fun fizzbuzz n = 
    if n mod 15 = 0 then
        "fizzbuzz"
    else if n mod 3 = 0 then
        "fizz"
    else if n mod 5 = 0 then
        "buzz"
    else
        Int.toString(n);

fun fizzbuzzwith1gives1() = 
    fizzbuzz(1) = "1";

fun fizzbuzzwith2gives2() = 
    fizzbuzz(2) = "2";

fun fizzbuzzwith3givesfizz() = 
    fizzbuzz(3) = "fizz";

fun fizzbuzzwith9givesfizz() = 
    fizzbuzz(9) = "fizz";

fun fizzbuzzwith5givesbuzz() = 
    fizzbuzz(5) = "buzz";

fun fizzbuzzwith10givesbuzz() = 
    fizzbuzz(10) = "buzz";

fun fizzbuzzwith15givesfizzbuzz() = 
    fizzbuzz(15) = "fizzbuzz";

fun fizzbuzzwith30givesfizzbuzz() = 
    fizzbuzz(30) = "fizzbuzz";

fun tests () = 
    fizzbuzzwith1gives1()
    andalso fizzbuzzwith2gives2()
    andalso fizzbuzzwith3givesfizz()
    andalso fizzbuzzwith9givesfizz()
    andalso fizzbuzzwith5givesbuzz()
    andalso fizzbuzzwith10givesbuzz()
    andalso fizzbuzzwith15givesfizzbuzz()
    andalso fizzbuzzwith30givesfizzbuzz()
    ;


tests();
