const db = require('../config/config');
const bcrypt = require('bcryptjs');

const User = {};

User.getAll = () => {
    const sql = `SELECT * FROM users`;
    return db.manyOrNone(sql);
}

User.create = async (user) => {
    const hash = await bcrypt.hash(user.password, 10);

    const sql = `INSERT INTO users (email,name,lastname,dni,edad,phone,image,password,created_at,updated_at) VALUES ($1 ,$2 ,$3 ,$4 ,$5 ,$6 ,$7 ,$8 ,$9 ,$10) RETURNING id`;

    return db.oneOrNone(sql, [
        user.email,
        user.name,
        user.lastname,
        user.dni,
        user.edad,
        user.phone,
        user.image,
        hash,
        new Date(),
        new Date()
    ]);
}

User.findByEmail = (email) => {
    const sql = `
    SELECT 
        id,
	    email,
	    name,
	    lastname,
        dni,
        edad,
	    image,
	    phone,
	    password,
	    session_token
    FROM
	    users
    WHERE 
	    email = $1
    `;

        return db.oneOrNone(sql, email);
}

User.findById = (id, callback) => {
    const sql = `
    SELECT 
	    id,
	    email,
	    name,
	    lastname,s
        dni,
        edad,
	    image,
	    phone,
	    password,
	    session_token
    FROM
	    users
    WHERE 
	    id = $1
    `;

        return db.oneOrNone(sql, id).then(user => { callback(null, user)})
}

module.exports = User;