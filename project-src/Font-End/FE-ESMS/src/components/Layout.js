import { Outlet } from "react-router-dom"

const Layout = () => {
    // this reperesent all the child of layout component
    // this allow us apply more thing to overall app
    return (
        <main className="App">
            <Outlet />
        </main>
    )
}

export default Layout
