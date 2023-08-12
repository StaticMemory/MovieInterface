import Link from "next/link";

export default function ActorResult(props){
    return <div><div className="flex">
        <Link href={"Actor/"+props.id}>{props.name}</Link>
        <img src={"https://image.tmdb.org/t/p/w500" + props.profile} width={100}></img>
    
    </div>


    </div>
}