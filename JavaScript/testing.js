<!DOCTYPE html>
<html>
<body>

<p>Click the button to loop through a block of code five times.</p>
<button onclick="myFunction()">Try it</button>
<p id="demo"></p>

<script>
function myFunction() {
    var x = "", i;
    for (i=0; i<5; i++) {
        x = x + "The number is " + i + "<br>";
    }
    document.getElementById("demo").innerHTML = x;
}

function subtract(x,y){
    return x - y;
}
</script>

</body>
</html>