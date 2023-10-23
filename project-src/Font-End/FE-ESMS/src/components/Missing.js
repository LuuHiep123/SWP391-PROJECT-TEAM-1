import { Link } from "react-router-dom"




const missingContainerStyle = {
    backgroundImage: `url('image/background.png')`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
    height: '100vh',
    display: 'flex', 
    justifyContent: 'center'
};

const thummail = {
    position: 'absolute',
};

const Missing = () => {
    return (
        <>
            <div style={missingContainerStyle} className="missing-container">
                <div style={thummail} className="thummail">
                    <img src="image/background.png" alt="thummail-fptu" />
                </div>
                <article style={{ padding: "100px" }}>
                    <h1>Oops!</h1>
                    <p>Page Not Found</p>
                    <div className="flexGrow">
                        <Link to="/login">Visit Our Login</Link>
                    </div>
                </article>
            </div>
        </>
    )
}

export default Missing
