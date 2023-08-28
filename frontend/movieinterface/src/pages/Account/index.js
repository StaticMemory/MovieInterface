import { getSession } from "next-auth/react";
import { useEffect } from "react";

export default function CheckUser( {user} ){
   
    return <><div></div></>
}



export async function getServerSideProps(context) {
    const session = await getSession(context)
    if (!session) {
      return {
        props: {}
      }
    }
    const signup = await fetch("http://localhost:8080/user/addUser",{method:"POST",
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'name' : session.user.name,
            'image' : session.user.image
        }})
    return {props: {}}
}
