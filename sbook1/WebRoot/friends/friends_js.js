// JavaScript Document 
$(document).ready(function(){
	$("#box1 .title").click(function(){
		$("#box1 .text").toggle();
		$("#box1 .down").toggleClass("up");
	});  
	$("#box2 .title").click(function(){
		$("#box2 .text").toggle();
		$("#box2 .down").toggleClass("up");
	});
}); 