import { useSession } from "next-auth/react";

export default function CheckUser(){
    const {data: session} = useSession();
    if(session){
        return <></>
    }
    return <></>
}