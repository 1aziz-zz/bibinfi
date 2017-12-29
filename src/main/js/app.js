const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {books: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/books'}).done(response => {
            this.setState({books: response.entity._embedded.books});
    });
    }

    render() {
        return (
            <BookList books={this.state.books}/>
    )
    }
}

class BookList extends React.Component{
    render() {
        var books = this.props.books.map(book =>
            <Employee key={book._links.self.href} book={book}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Title</th>
                    <th>isbn</th>
                    <th>year</th>
                </tr>
                {books}
                </tbody>
            </table>
        )
    }
}

class Book extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.book.title}</td>
                <td>{this.props.book.isbn}</td>
                <td>{this.props.book.year}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)