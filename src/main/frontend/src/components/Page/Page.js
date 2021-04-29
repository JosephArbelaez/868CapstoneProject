import React, {Component} from 'react';
import AdminAccount from './AdminAccount';
import Login from './Login';
import UserAccount from './UserAccount';
import BookCatalog from '../Catalog/BookCatalog';

const initialState = {
    userID: '',
    name: '',
    username: '',
    password: '',
    cardNumber: ''
  }

class Page extends Component {
    constructor() {
        super();
        this.state = initialState;
    }

    login = (userID, name, cardNumber) => {
        console.log("From Page.js");
        this.setState({
            userID: userID,
            name: name,
            cardNumber: cardNumber,
        });

        if(this.state.cardNumber === undefined) {
            this.props.pageChange('adminAccount');
        } else {
            this.props.pageChange('userAccount')
        }
    }

    renderSwitch(name, userID, cardNumber){
        switch(this.props.page){
            case 'login':
                return (
                    <Login 
                        name = {name} 
                        userID = {userID} 
                        cardNumber = {cardNumber} 
                        login={this.login}/>
                )
            case 'userAccount':
                return (
                    <UserAccount 
                        name = {name}
                        userID = {userID}
                        cardNumber = {cardNumber}/>
                )

            case 'adminAccount':
                return (
                    <AdminAccount 
                    name = {name}
                    userID = {userID}
                    cardNumber = {cardNumber}/>
                )
            
            default:
                return (
                    <BookCatalog />
                )
        }
    }
    render() {
        const {userID, name, cardNumber} = this.state;
        return (
            <div className = "content">
                {this.renderSwitch (name, userID, cardNumber)}
            </div>
        )
    }
}

export default Page;