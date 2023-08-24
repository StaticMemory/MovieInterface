import NextAuth from "next-auth/next";
import GoogleProvider from 'next-auth/providers/google'
import info from "../../../../api/AuthData.json" 
export default NextAuth({
    

    providers: [
        GoogleProvider({
            clientId: "",
            clientSecret : ""
        }),
    ]
})