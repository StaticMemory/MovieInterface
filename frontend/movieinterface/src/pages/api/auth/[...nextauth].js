import NextAuth from "next-auth/next";
import GoogleProvider from 'next-auth/providers/google'
import info from "../../../../api/AuthData.json" 
export default NextAuth({

    callbacks: {
        async redirect({url, baseUrl}){
            return "http://localhost:3000/Account";
        }
    },
    providers: [
        GoogleProvider({
            clientId: info['ClientID'],
            clientSecret : info['ClientSecret']
        }),
    ]
})