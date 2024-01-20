
-- Create the table if it doesn't exist
CREATE TABLE IF NOT EXISTS netflix_titles (
                                              show_id VARCHAR(255) PRIMARY KEY,
    type VARCHAR(255),
    title VARCHAR(255),
    director VARCHAR(255),
    actors VARCHAR(255),
    country VARCHAR(255),
    date_added VARCHAR(255),
    release_year INT,
    rating VARCHAR(255),
    duration VARCHAR(255),
    listed_in VARCHAR(255),
    description VARCHAR(255)
    );


INSERT INTO netflix_titles (show_id, type, title, director, actors, country, date_added, release_year, rating, duration, listed_in, description)
VALUES
    ('show_1', 'Movie', 'Title 1', 'Director 1', 'Actor1, Actor2, Actor3', 'Country 1', '2022-01-01', 1985, 'PG-13', '120 min', 'Genre 1', 'Description for Title 1'),
    ('show_2', 'TV Show', 'Title 2', 'Director 2', 'Actor4, Actor5, Actor6', 'Country 2', '2022-01-02', 2000, 'PG', '45 min', 'Genre 2', 'Description for Title 2'),
    ('show_3', 'Movie', 'Title 3', 'Director 3', 'Actor7, Actor8, Actor9', 'Country 3', '2022-01-03', 1995, 'R', '90 min', 'Genre 3', 'Description for Title 3'),
    ('show_4', 'TV Show', 'Title 4', 'Director 4', 'Actor10, Actor11, Actor12', 'Country 4', '2022-01-04', 1980, 'PG-13', '60 min', 'Genre 4', 'Description for Title 4'),
    ('show_100', 'Movie', 'Title 100', 'Director 100', 'Actor295, Actor296, Actor297', 'Country 100', '2022-01-100', 2005, 'PG', '150 min', 'Genre 100', 'Description for Title 100');
