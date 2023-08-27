import { useSession } from "next-auth/react";
import { useEffect } from "react";
function CreateUser(){
    
    const {data: session} = useSession();
    useEffect(()=>{
        const checkUser = async ()=>{
            const signup = await fetch("http://localhost:8080/user/addUser",{method:"POST",
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'name' : session.user.name,
            'image' : session.user.image
        }})
        }
        if(session){
            checkUser();
        }
    },[]);
    if(session){
        return <><div className="text-white text-center">Logging you in!</div></>
    }
    return <><div className="text-white">Logged you out!</div></>
}
export default function CheckUser(){
    return <><CreateUser></CreateUser></>
}

