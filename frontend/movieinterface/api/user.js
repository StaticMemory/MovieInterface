async function requestUser(userid){
    const userData = await fetch("http://localhost:8080/user/returnUserByName",{method : "GET",
    headers:{ "user" : userid
}});
    const userJsonData = await userData.json();
    return userJsonData
}