// Basic Data Handling
// Importing movies dataset and functions
import { movies } from "./movies.js";
import {
  findFirstHighRatedMovie,
  sortMoviesByRating,
  displayMovieSummary,
  createMovieObject,
  logSelectedMovies,
  addWatchedFlag,
  getMoviesAfter,
  getAverageRating,
  findMovie,
  areAllAbove,
  getMoviesByGenre,
  getLongestMovie,
} from "./utils.js";

// Arrow function calling the dataset sorted by year release
const printMovieStats = (movies) => {
  let sortedMovies = [...movies].sort((a, b) => a.year - b.year);
  for (const {
    title: t,
    year: y,
    genre: g,
    rating: r,
    duration: d,
  } of sortedMovies) {
    console.log(`Title      : ${t}`);
    console.log(`Year       : ${y}`);
    console.log(`Genre      : ${g}`);
    console.log(`Rating     : ${r}/10`);
    console.log(`Duration   : ${d} minutes`);
    console.log(``);
  }
};
// Calling function
printMovieStats(movies);

// Advanced JavaScript Features
// Object Destructuring
findFirstHighRatedMovie(movies);

// Array Destructuring
sortMoviesByRating(movies);

// Function Argument Destructuring
movies.forEach(displayMovieSummary);
console.log(``);

// Object literal enhancement / restructuring
const newMovie = createMovieObject("Flow", 2024, "Fantasy", 7.9, 85);
const exists = movies.some((movie) => movie.title === newMovie.title);
let newMovies;
if (!exists) {
  newMovies = [...movies, newMovie];
  console.log(`New Movie added: ${newMovie.title}`);
} else {
  newMovies = [...movies];
  console.log(`Movie already exist, no change were added.`);
}

// Spread operator
// Combine Arrays
const newReleases = [
  {
    id: 11,
    title: "A Silent Voice",
    year: 2016,
    genre: "Drama",
    rating: 8.2,
    duration: 130,
  },
  {
    id: 12,
    title: "Demon Slayer: Infinity Castle",
    year: 2025,
    genre: "Action",
    rating: 8.6,
    duration: 155,
  },
  {
    id: 13,
    title: "Spirited Away",
    year: 2001,
    genre: "Fantasy",
    rating: 8.6,
    duration: 125,
  },
];
const allMovies = [...newMovies, ...newReleases];
console.log(allMovies);
console.log(``);

// Clone the Array
const allMoviesClone = [...allMovies];
allMoviesClone.push({
  id: 14,
  title: "Josee, the Tiger and the Fish",
  year: 2020,
  genre: "Romance",
  rating: 7.6,
  duration: 98,
});
console.log(allMoviesClone);
console.log(allMovies);
console.log(``);

// Split Top and Remaining Movies with Spread
let topMovies;
const getTopAndRemainingMovies = (movies) => {
  movies.sort((a, b) => b.rating - a.rating);
  const [first, second, third, ...rest] = movies;
  topMovies = [first, second, third];
  const remainingMovies = rest;
  console.log(`Top ${topMovies.length} movies: `);
  console.log(topMovies);
  console.log(``);
  console.log(`Remaining Movies: `);
  console.log(remainingMovies);
  console.log(``);
};
getTopAndRemainingMovies(allMovies);

// Collect Function Arguments Using Rest Parameters
logSelectedMovies(...topMovies.map((movie) => movie.title));

// Functional Programming
const moviesWithWatched = addWatchedFlag(allMovies);
console.log(`Movies with watched flag: `);
moviesWithWatched.forEach(movie => console.log(`- ${movie.title} (${movie.watched})`));
console.log(``);

const moviesAfter2010 = getMoviesAfter(2010,allMovies);
console.log(`Movies after 2010:`);
moviesAfter2010.sort((a,b) => a.year-b.year);
moviesAfter2010.forEach(movie => console.log(`- ${movie.title} (${movie.year})`));
console.log(``);

const avgRating = getAverageRating(allMovies);
console.log(`Average Rating for all movies: ${avgRating.toFixed(2)}`)
console.log(``);

const findInception = findMovie("INCEPTION",allMovies);
console.log(`Find 'Inception': ${findInception ? findInception.title + ' (' + findInception.year + ')' : 'Not Found'}`);
console.log(``)

const ratingAbove7_5 = areAllAbove(7.5,allMovies);
console.log(`Are all movies rated above 7.5? ${ratingAbove7_5}`);
console.log(``);

const scifiMovie = getMoviesByGenre("sci-Fi",allMovies);
console.log(`Sci-Fi Movies: `);
scifiMovie.sort((a,b)=>a.year-b.year);
scifiMovie.forEach(movie=> console.log(`- ${movie.title} (${movie.year})`));
console.log(``);

const longestMovie = getLongestMovie(allMovies);
console.log(`Longest Movie: ${longestMovie.title} (${longestMovie.duration} mins.)`);
console.log(``);