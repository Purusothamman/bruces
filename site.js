var ptag=document.getElementByClass("clock");
setInterval(function(){
var dt=newDate(0);
var t=dt.toLocalTimeString();
ptag.innerText=t;
},1000);