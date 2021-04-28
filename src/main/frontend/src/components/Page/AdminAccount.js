import axios from 'axios';
import React, { Component } from 'react';

class AdminAccount extends Component {
    constructor(props) {
        super(props);
    };

    render() {
        return (
            <div>
                <h1>AdminAccount</h1>
                <h1>{this.props.userID}</h1>
                <h1>{this.props.name}</h1>
            </div>
        );
    }
}

export default AdminAccount;