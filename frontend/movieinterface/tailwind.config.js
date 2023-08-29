/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      backgroundImage: {
        'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
        'gradient-conic':
          'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
      },
      colors: {
        'defaultColour' : "#3C3F3C",
        'offgray' : '#9BA29C',
        'offgrayhighlight' : "#3F3B33",
        'LinkColour' : '#AF2A2A'
      },
      width : {
        'PreviewCardWidth': '32rem',
        'MovieSearchWidth' : '32rem',
        'ScreenWidth' : '100vh',
        'EpisodeWidth' : '48rem',
      }
    },
  },
  plugins: [],
}
