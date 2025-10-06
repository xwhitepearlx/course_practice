export const findFirstHighRatedMovie = (movies) => {
  for (const { title, year, rating } of movies) {
    if (rating > 8.8) {
      console.log(`${title} (${year}) has an IMDb rating of ${rating}/10.`);
      console.log(``);
      break;
    }
  }
};

export const sortMoviesByRating = (movies) => {
  let sortedMovies = [...movies].sort((a, b) => b.rating - a.rating);
  let [topMovie1, topMovie2, ...otherTopMovies] = sortedMovies;
  console.log(`1st ranked movie - ${topMovie1.title}`);
  console.log(`2nd ranked movie - ${topMovie2.title}`);
  console.log(`Other top movies: `);
  for (const movie of otherTopMovies) {
    console.log(`-  ${movie.title}`);
  }
  console.log(``);
};

export const displayMovieSummary = ({ title, year, genre }) => {
  console.log(`${title} (${year} – Genre: ${genre})`);
};

export const createMovieObject = (title, year, genre, rating, duration) => {
  return { title, year, genre, rating, duration };
};

export const logSelectedMovies = (...movieTitles) => {
  console.log(`You selected: ${movieTitles.join(", ")}`);
};

// Functional Programming

export const addWatchedFlag = (movies) =>
  movies.map((movie) => ({ ...movie, watched: false }));

export const getMoviesAfter = (year, movies) =>
  movies.filter((movie) => movie.year > year);

export const getAverageRating = (movies) => {
  const totalRating = movies.reduce((accu, movie) => accu + movie.rating, 0);
  return totalRating / movies.length;
};

export const findMovie = (title, movies) =>
  movies.find((movie) => movie.title.toLowerCase() === title.toLowerCase());

export const areAllAbove = (rating, movies) =>
  movies.every((movie) => movie.rating > rating);

export const getMoviesByGenre = (genre, movies) =>
  movies.filter((movie) => movie.genre.toLowerCase() === genre.toLowerCase());

export const getLongestMovie = (movies) =>
  movies.reduce((longestTemp, movie) =>
    longestTemp.duration < movie.duration ? movie : longestTemp
  );

