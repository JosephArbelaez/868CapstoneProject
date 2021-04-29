import axios from 'axios';
import React from 'react';
import BookCard from './BookCard';

const BookCatalog = ({ books }) => {
    if(books == undefined){
        return(
            <div></div>
        )
    }
    return (
        <div>
            {
                books.map((book, i) => {
                    console.log(book);
                    return (
                        <BookCard 
                            key = {i} 
                            isbn = {book.isbn}
                            title= {book.title}
                            author = {book.author}
                            description = {book.description}
                            pageCount = {book.pageCount}
                            price = {book.price}
                            genre = {book.genre}
                            status = {book.status}/>
                    );
                })
            }
        </div>
    );
}

export default BookCatalog;