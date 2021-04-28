import axios from 'axios';
import React, { Component } from 'react';

class UserAccount extends Component {
    constructor(props) {
        super(props);
    };

    render() {
        return (
            <div>
                <h1>UserAccount</h1>
                <h1>{this.props.userID}</h1>
                <h1>{this.props.name}</h1>
                <h1>{this.props.cardNumber}</h1>
            </div>
        );
    }
}

export default UserAccount;