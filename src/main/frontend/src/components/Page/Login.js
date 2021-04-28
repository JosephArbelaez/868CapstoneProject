import axios from 'axios';
import React, { Component } from 'react';

class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: ""
        };

        this.handleChange = this.handleChange.bind(this);
        this.login = this.login.bind(this);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }
    login = (event) => {
        event.preventDefault()
        const { username, password} = this.state;

        axios.get(
            `http://localhost:8080/api/v1/person/login?username=${username}&password=${password}`
        ).then(res => {
            this.props.login(res.data.userID, res.data.name, res.data.cardNumber);
        });
    }
    render() {
        return (
            <div onSubmit={this.login} className="loginPage">
                <form >
                    <label>
                        Username:
                        <input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                    </label>
                    <label>
                        Password:
                        <input type="text" name="password" value={this.state.password} onChange={this.handleChange} />
                    </label>
                    <input type="submit" value="Login" />
                </form>
            </div>
        );
    }
}

export default Login;