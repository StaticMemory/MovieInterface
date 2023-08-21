import Link from "next/link";

export default function ActorResult(props){
    return <div className="w-MovieSearchWidth">
        
    <div className="text-white flex w-32 border-2">
        <div>
            <div className="text-center italic font-bold underline">
                <Link href={"/Actor?&id="+props.id} className="w-MovieSearchWidth">{props.name}</Link><div className="h-full">
                    <img src={"https://image.tmdb.org/t/p/w500"+props.profile}></img>
                </div>
            </div>
        </div>{props.info}
    </div>
</div>
}