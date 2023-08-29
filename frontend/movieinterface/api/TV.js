var URL = "http://localhost:8080/"
export async function getSeasonEpisodes(seriesID, seasonNo){
    const data = await fetch(URL + "Series/episodeList", {method:"GET",
    headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : seriesID,
        'seasonNum' : seasonNo
    }});
    const ret = await data.json();
    return ret;
}
export async function getSeriesData(seriesID){
    const data = await fetch(URL + "Series/getSeriesOverview",{method:"GET",
    headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : seriesID
    }});
    const ret = await data.json();
    return ret;
}