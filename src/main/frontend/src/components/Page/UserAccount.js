import axios from 'axios';
import React, { Component } from 'react';
import BookCatalog from '../Catalog/BookCatalog';

class UserAccount extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: []
        };

    };

    componentDidMount() {
        axios.get(`http://localhost:8080/api/v1/book`)
        .then((res) => {
            this.setState({
                books : res.data
            });
        })
    }
    render() {
        return (
            <div>
                <h1>UserAccount</h1>
                <h1>{this.props.userID}</h1>
                <h1>{this.props.name}</h1>
                <h1>{this.props.cardNumber}</h1>
                <BookCatalog books={this.state.books}/>
            </div>
        );
    }
}

export default UserAccount;