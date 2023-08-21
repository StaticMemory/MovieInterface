export default function MovieSplashPage(props){
 
    return <> 
    <div className="text-white text-center font-bold text-3xl">
        {props.name}
    </div>
    <br></br>
    <hr></hr>
    <br></br>
    <div className="text-white ">
        <div>
            <div className="flex">
                <div className="p-1">
                    <img src={"https://image.tmdb.org/t/p/w500/" + props.posterPath} height={250} width={300} alt="No Image Available"></img>
                        <div className="text-center">
                            <i>
                                {props.tagline}
                            </i>
                        </div>
                    </div>
                 Synopsis: {props.overview}
            </div>
            <hr></hr>
            <div className="text-4xl">{    // Put actor photos with name down here in a flex box.
}               Starring:
            </div> 
        </div>
    </div>
    <br></br>
    
    
    
    
    
    
    
    
    
    
    </>
}