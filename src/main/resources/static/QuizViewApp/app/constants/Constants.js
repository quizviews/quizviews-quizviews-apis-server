var app = angular.module("QuizViewApp");

app.constant("constants", {
//	BASE_URL : "https://localhost:80/api/",
//	 BASE_URL : "https://quizviews.com/api/",
	BASE_URL : "https://quizviews.herokuapp.com/api/",
	PORT : "80"
});

app.value("FieldTypes", {
	titleTest : [ "Text", "	should be a text" ],
	text : [ "Text", "should be a text" ],
	email : [ "Email", "should be an email" ],
	number : [ "Number", "should be a text" ],
	date : [ "Date", "should be a text" ],
	datetime : [ "Datetime", "should be a text" ],
	time : [ "Time", "should be a text" ],
	month : [ "Month", "should be a text" ],
	week : [ "Week", "should be a text" ],
	// url : [ "URL", "should be a url , starting with http" ],
	website : [ "url", "should be a url , starting with http" ],
	tel : [ "Phone Number", "should be a text" ],
	color : [ "Color", "should be a text" ]
});

app.value("TypeMessages", {
	text : [ "Text", "should be a text" ],
	email : [ "Email", "should be an email" ],
	number : [ "Number", "should be a text" ],
	date : [ "Date", "should be a text" ],
	datetime : [ "Datetime", "should be a text" ],
	time : [ "Time", "should be a text" ],
	month : [ "Month", "should be a text" ],
	week : [ "Week", "should be a text" ],
	url : [ "URL", "should be a url , starting with http" ],
	tel : [ "Phone Number", "should be a text" ],
	color : [ "Color", "should be a text" ]
});
