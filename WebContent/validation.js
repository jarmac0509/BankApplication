function checkForm() {
        var name=$("#name").val();

        if (name.length<2) {
            $("#nameError").html("please, provide your name");
            return false;
        }
        return true;
    }
function isNumeric(input) {
    var RE = /^-{0,1}\d*\.{0,1}\d+$/;
if(RE.test(input))
return true;
   else {
alert("please provide valid number");
return false; 
}
}

   function checkForm2() {
   var checkResult = true;
   var email = $("#email").val();


      if (!email.match(".+@.+\.[a-zA-Z]{2,3}")) {
         $("#emailError").html("invalid e-mail format");
         checkResult=false;
      }
var name = $("#name").val();
var nameArr = name.split(" ");
if(nameArr.length<2){
$("#nameError").html("please provide full name");
checkResult=false;}
for(var i=0;i<nameArr.length;i++) {
      var n = nameArr[i];
       if(n.length<2){
       $("#nameError").html("please provide full name");
       checkResult=false;}
      
}
return checkResult;
}