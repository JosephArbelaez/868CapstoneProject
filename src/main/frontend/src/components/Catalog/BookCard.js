import React from 'react';

const BookCard = ({isbn, title, author, description, pageCount, price, genre, status}) => {

    return (
        <div>
            <div>
                <p>{isbn}</p>
                <p>{title}</p>
                <p>{author}</p>
                <p>{description}</p>
                <p>{pageCount}</p>
                <p>{price}</p>
                <p>{genre}</p>
                <p>{status}</p>
            </div>
        </div>
    );
}

export default BookCard;