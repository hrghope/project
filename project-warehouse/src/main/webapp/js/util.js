function getDateString(date){
	if(date==null){
		return "";
	}
	var myDate=new Date();
	myDate.setTime(date);
	return myDate.toLocaleString();
}