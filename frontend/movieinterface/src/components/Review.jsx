import { useRouter } from "next/router"

export default function ReviewPanel(props){
    const router = useRouter();
    return <>
    <div className="flex"><div className="text-white"><button
    onClick={()=>{
        router.push("/User/" + props.authID)
    }}>{props.author}</button></div>
    </div>
    
    <div className="border-2 relative w-64">
        <div className="flex">
            <div className="text-white text-center">{props.data} </div>
        </div>
        

    </div>
    <div className="text-xs">{props.date}</div>
    <br></br>
    </>
}