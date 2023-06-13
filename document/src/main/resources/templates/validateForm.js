function validateForm(){
    console.log("at validateForm.js");
    var x = document.forms["myForm"]["Username"].value;
    var y = document.forms["myForm"]["Password"].value;
    if(x == "" || x == null || y == "" || y == null){
        alert("Please fill out all the fields");
        return false;
    }
    return true;
}